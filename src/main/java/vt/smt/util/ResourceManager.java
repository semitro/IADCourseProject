package vt.smt.util;

import vt.smt.ent.net.Resource;

import java.io.InputStream;

public class ResourceManager {
    public static InputStream loadResource(Resource res){
        return ResourceManager.class.getResourceAsStream(res.getUrl());
    }
}
