package com.engine2d.utils;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageProcessing {
	
	public static BufferedImage deepCopyImage(BufferedImage image) {
		ColorModel colorModel = image.getColorModel();
		boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
		WritableRaster raster = image.copyData(null);
		
		return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
	}
	
	
	
}
