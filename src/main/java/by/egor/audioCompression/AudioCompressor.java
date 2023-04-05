package by.egor.audioCompression;

import javax.sound.sampled.*;
import java.io.*;

public class AudioCompressor {
    public static void compressAudio(String sourceFile) {
        try {
            // Open the source audio file
            File fileIn = new File(sourceFile);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileIn);

            // Set the target audio format
            AudioFormat sourceFormat = audioInputStream.getFormat();
            AudioFormat targetFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    sourceFormat.getSampleRate()/2,
                    16,
                    sourceFormat.getChannels(),
                    sourceFormat.getChannels() * 2,
                    sourceFormat.getSampleRate(),
                    false
            );

            // Create the compressor
            AudioInputStream targetStream = AudioSystem.getAudioInputStream(targetFormat, audioInputStream);

            // Create the output file in the "Compressed" subdirectory
            File compressedFolder = new File(fileIn.getParentFile(), "Compressed");
            if (!compressedFolder.exists()) {
                compressedFolder.mkdir();
            }
            String targetFile = new File(compressedFolder, fileIn.getName()).getPath();
            File fileOut = new File(targetFile);
            AudioSystem.write(targetStream, AudioFileFormat.Type.WAVE, fileOut);

            // Close the streams
            targetStream.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
