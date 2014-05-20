package com.ethanwong.framework;

import com.ethanwong.framework.Graphics.ImageFormat;;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
 