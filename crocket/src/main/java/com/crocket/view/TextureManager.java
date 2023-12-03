package com.crocket.view;

import java.io.File;


import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class TextureManager {

    private static final String JSON_FILE_PATH = "crocket\\assets\\textures\\Textures.json";



    private Map<String, BufferedImage> textureCacheMap;

    protected TextureManager() {
        this.textureCacheMap = new HashMap<>();
    }

    protected void loadTextures() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Map<String, String>> textureMap = mapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<Map<String, String>>>() {});
            for (Map<String, String> texture : textureMap) {
                String textureName = texture.get("Name");
                String texturePath = texture.get("TexturePath");
                BufferedImage textureImage = ImageIO.read(new File(texturePath));
                textureCacheMap.put(textureName, textureImage);
            }
        } catch (Exception ex) {
            System.out.println("Error loading textures: " + ex.getMessage());
        }
    }


    public BufferedImage getTexture(String textureName) {
        if (!textureCacheMap.containsKey(textureName)) {
            throw new IllegalArgumentException("Invalid texture name " + textureName);
        }
        return textureCacheMap.get(textureName);
    }
}
