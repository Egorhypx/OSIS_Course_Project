package by.egor.videoCompression;

import io.github.techgnious.IVCompressor;
import io.github.techgnious.dto.ResizeResolution;
import io.github.techgnious.dto.VideoFormats;
import io.github.techgnious.exception.VideoException;

import java.io.File;
import java.io.IOException;

public class VideoCompressor {

    public void compressVideo(String videoPath) {
        try {
            IVCompressor compressor = new IVCompressor();
            File inputFile = new File(videoPath);

            File compressedFolder = new File(inputFile.getParentFile(), "Compressed");
            if (!compressedFolder.exists()) {
                compressedFolder.mkdir();
            }

            // Compress video and save to the "Compressed" folder
            compressor.reduceVideoSizeAndSaveToAPath(inputFile, VideoFormats.MP4, ResizeResolution.R240P, compressedFolder.getAbsolutePath());
        } catch (VideoException e) {
            System.out.println("Cannot compress video\n");
        } catch (IOException e) {
            System.out.println("Smth wrong with the video, try another one\nOr wrong path input\n");
        }
    }


}
