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

    public BufferedImage getTexture(String textureName) {
        if (!textureCacheMap.containsKey(textureName)) {
            throw new IllegalArgumentException("Invalid texture name " + textureName);
        }
        return textureCacheMap.get(textureName);
    }

    protected synchronized void loadTextures() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("crocket\\assets\\textures\\Textures.json");
            JSONArray textureTypes = (JSONArray) parser.parse(reader);
            for (Object type : textureTypes) {
                JSONObject TextureObject = (JSONObject) type;
                JSONArray TextureObjectList = (JSONArray) TextureObject.get("SurfaceTextureList");
                if (TextureObjectList != null) {
                    for (Object object : TextureObjectList) {
                        convertDataToImage(object);
                    }
                }
                TextureObjectList = (JSONArray) TextureObject.get("EntityTextureList");
                if (TextureObjectList != null) {
                    for (Object object : TextureObjectList) {
                        convertDataToImage(object);
                    }
                }
            }
        } catch (ParseException ex) {
            System.out.println("Error parsing textures.json file");
        } catch (IOException ex) {
            System.out.println("Error bad path to texture in json file");
        }
    }

    private void convertDataToImage(Object object) throws IOException {
        JSONObject textureObjectJSON = (JSONObject) object;
        String textureName = (String) textureObjectJSON.get("Name");
        String texturePath = (String) textureObjectJSON.get("TexturePath");
        BufferedImage texture = ImageIO.read(new File(texturePath));
        textureCacheMap.put(textureName, texture);
    }
}