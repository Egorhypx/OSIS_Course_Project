package by.egor.view;

import by.egor.factory.CompressorFactory;
import by.egor.imageCompression.ImageLossyCompressor;
import by.egor.videoCompression.VideoCompressor;
import by.egor.audioCompression.AudioCompressor;
import io.github.techgnious.exception.VideoException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.awt.*;

public class Menu {
    public static void start() throws IOException, VideoException {
        CompressorFactory compressorFactory = CompressorFactory.getInstance();
        ImageLossyCompressor imageLossyCompressor = compressorFactory.getImageLossyCompressor();
        VideoCompressor videoCompressor = compressorFactory.getVideoCompressor();
        AudioCompressor audioCompressor = compressorFactory.getAudioCompressor();

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        while (true) {
            printMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {

                    FileDialog fileDialog = new FileDialog((Frame) null, "Select a image");
                    fileDialog.setMode(FileDialog.LOAD);
                    fileDialog.setFile("*.jpg;*.jpeg");
                    fileDialog.setVisible(true);
                    fileDialog.setAlwaysOnTop(true);

                    if (fileDialog.getFile() != null) {
                        String imagePath = fileDialog.getDirectory() + fileDialog.getFile();
                        imageLossyCompressor.compressImage(imagePath);
                    }
                    System.out.println("Image compression is done!");
                }
                case "2" -> {
                    FileDialog fileDialog = new FileDialog((Frame) null, "Select a video");
                    fileDialog.setMode(FileDialog.LOAD);
                    fileDialog.setFile("*.mp4");
                    fileDialog.setVisible(true);
                    fileDialog.setAlwaysOnTop(true);

                    if (fileDialog.getFile() != null) {
                        String videoPath = fileDialog.getDirectory() + fileDialog.getFile();
                        videoCompressor.compressVideo(videoPath);
                    }
                    System.out.println("Video compression is done!");
                }
                case "3" -> {
                    FileDialog fileDialog = new FileDialog((Frame) null, "Select a audio");
                    fileDialog.setMode(FileDialog.LOAD);
                    fileDialog.setFile("*.wav");
                    fileDialog.setVisible(true);
                    fileDialog.setAlwaysOnTop(true);

                    if (fileDialog.getFile() != null) {
                        String videoPath = fileDialog.getDirectory() + fileDialog.getFile();
                        audioCompressor.compressAudio(videoPath);
                    }
                    System.out.println("Audio compression is done!");
                }
                case "e" -> System.exit(0);
                default -> System.out.println("No such command. Try again");
            }
        }
    }

    private static void printMenu() {
        System.out.println("------------------------");
        System.out.println("1. Compress image");
        System.out.println("2. Compress video");
        System.out.println("3. Compress audio");
        System.out.println("e. Exit");
        System.out.println("------------------------");
    }
}
