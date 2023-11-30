package com.crocket;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TextureManager {

    private Map<String, BufferedImage> textureCacheMap;

    protected TextureManager() {
        this.textureCacheMap = new HashMap<>();
    }

    public BufferedImage getTexture(String textureName){
        System.err.println(textureName.hashCode());
        if (!textureCacheMap.containsKey(textureName)) {
            throw new IllegalArgumentException("Invalid texture name " + textureName);
        }
        return textureCacheMap.get(textureName);
    }

    protected void loadTextures() throws IOException{
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader("crocket\\src\\main\\java\\com\\crocket\\Textures.json");
            JSONArray textureTypes = (JSONArray) parser.parse(reader);
            for (Object type : textureTypes) {
                JSONObject TextureObject  = (JSONObject) type;
                JSONArray TextureObjectList = (JSONArray) TextureObject.get("EntityTextureList"); 
                if (TextureObjectList == null) {
                    TextureObjectList = (JSONArray) TextureObject.get("SurfaceTextureList");
                }
                for(Object object : TextureObjectList){
                    convertTextureToImage(object);
                }
            }
        }catch(ParseException ex){
            System.out.println("Error parsing textures.json file");
        }
        
    }

    private void convertTextureToImage(Object object) throws IOException {
        JSONObject textureObjectJSON = (JSONObject) object;
        String textureName = (String) textureObjectJSON.get("Name");
        System.out.println(textureName);
        String texturePath = (String) textureObjectJSON.get("TexturePath");
        BufferedImage texture = ImageIO.read(new File(texturePath));
        textureCacheMap.put(textureName, texture);
    }
}