package dockercontroller.daedalus.manager;

import dockercontroller.daedalus.service.ImageService;

public class ImageManager implements ImageService{
    private final String PHPBuildImage = "freezerglp/centos-apache-php";
    @Override
    public String getPHPBuildImage() {
        return PHPBuildImage;
    }

}
