package by.egor.factory;

import by.egor.audioCompression.AudioCompressor;
import by.egor.imageCompression.ImageLossyCompressor;
import by.egor.videoCompression.VideoCompressor;

public class CompressorFactory {
    private static final CompressorFactory instance = new CompressorFactory();

    private final ImageLossyCompressor imageLossyCompressor;
    private final VideoCompressor videoCompressor;
    private final AudioCompressor audioCompressor;

    public CompressorFactory() {
        imageLossyCompressor = new ImageLossyCompressor();
        videoCompressor = new VideoCompressor();
        audioCompressor = new AudioCompressor();
    }

    public static CompressorFactory getInstance() {
        return instance;
    }

    public ImageLossyCompressor getImageLossyCompressor() {
        return imageLossyCompressor;
    }

    public VideoCompressor getVideoCompressor() {
        return videoCompressor;
    }

    public AudioCompressor getAudioCompressor() {
        return audioCompressor;
    }
}
