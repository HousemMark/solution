package com.mark.solution.factory;

public class BeanFactory {

    public Computer createComputer(String type){
        switch (type) {
            case "macBook" :
                return new MacBook();
            case "surface" :
                return new SurfaceBook();
        }
        return null;
    }
}
