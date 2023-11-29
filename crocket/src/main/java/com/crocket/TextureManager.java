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
    //private EnumMap<Surface, BufferedImage> surfaceTextureMap;
    //private EnumMap<EntityType, BufferedImage> entityTextureMap;

    protected TextureManager() {
        textureCacheMap = new HashMap<>();
    }

    public BufferedImage getTexture(String textureName){
        if (!textureCacheMap.containsKey(textureName)) {
            throw new IllegalArgumentException("Invalid texture name");
        }
        return textureCacheMap.get(textureName);
    }

    protected void loadTextures() throws IOException, ParseException {
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
        }catch(IllegalArgumentException ex){
            System.out.println("JSON file is not found");
        }
        
    }

    private void convertTextureToImage(Object object) throws IOException {
        JSONObject textureObjectJSON = (JSONObject) object;
        String textureName = (String) textureObjectJSON.get("Name");
        String texturePath = (String) textureObjectJSON.get("TexturePath");
        BufferedImage texture = ImageIO.read(new File(texturePath));
        textureCacheMap.put(textureName, texture);
    }





    /* 
    private void addSurfaceTexture(Surface surface, BufferedImage textureFile) {
        surfaceTextureMap.put(surface, textureFile);
    }

    private void addEntityTexture(EntityType entityType, BufferedImage textureFile) {
        entityTextureMap.put(entityType, textureFile);
    }

    private void updateSurfaceTextureMap(Surface surface, String texturePath) throws IOException {
        if (!surfaceTextureMap.containsKey(surface)) {
            BufferedImage surfaceTexture = ImageIO.read(new File(texturePath));
            addSurfaceTexture(surface, surfaceTexture);
        }
    }

    private void updateEntityTextureMap(EntityType entityType, String texturePath) throws IOException {
        if (!entityTextureMap.containsKey(entityType)) {
            BufferedImage entityTexture = ImageIO.read(new File(texturePath));
            addEntityTexture(entityType, entityTexture);
        }
    }

    public BufferedImage getSurfaceTexture(Surface surface) {
        return surfaceTextureMap.get(surface);
    }
    
    public BufferedImage getEntityTexture(EntityType entityType) {
        return entityTextureMap.get(entityType);
    }
    
    public void updateSurfaceTextures(Surface surface) throws IOException {
        switch (surface) {
            case GRASS:
                updateSurfaceTextureMap(surface, "crocket/assets/textures/GrassTile.png");
                break;
            case SAND:
                updateSurfaceTextureMap(surface, "crocket/assets/textures/SandTile.png");
                break;
            case ICE:
                updateSurfaceTextureMap(surface, "crocket/assets/textures/IceTile.png");
                break;
            default:
                throw new IllegalArgumentException("Invalid surface type");
        }
    }

    public void updateEntityTextures(EntityType entityType, int rotation) throws IOException {
        switch (entityType) {
            case BALL:
                updateEntityTextureMap(entityType, "crocket/assets/textures/Ball.png");
                break;
            case HOOP:
                updateEntityTextureMap(entityType, "crocket/assets/textures/Hoop.png");
                break;
            case PEG:

                break;
            
            default:
                throw new IllegalArgumentException("Invalid entity type");
        }
    }
    */


}