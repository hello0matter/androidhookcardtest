package com.example.msphone;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.FileObserver;
import android.util.Log;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class MyFileObserver extends FileObserver {

    private static final String TAG = "MyFileObserver";
    private static final String DIRECTORY_PATH = "/sdcard/TaxiDriver/TempAudio/";

    private static SimpleExoPlayer player = null;
    private static Context content = null;

    public MyFileObserver() {
        super(DIRECTORY_PATH, FileObserver.CREATE | FileObserver.DELETE);
    }

    public static void init(Context context) {
        content = context;
    }

    @Override
    public void onEvent(int event, String path) {
        switch (event) {
            case FileObserver.CREATE:
                try {
//                    Object ijkMediaPlayerInstance = param3.thisObject;
                    String audioSource = path;//(String) param3.args[0]; // 假设第一个参数是音频源
//                    //Log.d("2332", "test" + audioSource + "");
//                    Method setSpeedMethod = ijkMediaPlayerInstance.getClass().getDeclaredMethod("pause");
//                    setSpeedMethod.invoke(ijkMediaPlayerInstance);
//                    setSpeedMethod = ijkMediaPlayerInstance.getClass().getDeclaredMethod("stop");
//                    setSpeedMethod.invoke(ijkMediaPlayerInstance);
//                    if (ijkMediaPlayerInstance != null) {
//                        try {
//                            // 获取IjkMediaPlayer实例的Class对象
//                            Class<?> clazz = ijkMediaPlayerInstance.getClass();
//                            // 获取setVolume方法的Method对象，注意参数类型匹配
//                            Method setVolumeMethod = clazz.getDeclaredMethod("setVolume", float.class, float.class);
//                            // 调用setVolume方法，传递两个float类型的0作为参数
//                            setVolumeMethod.invoke(ijkMediaPlayerInstance, 0f, 0f);
//                        } catch (NoSuchMethodException e) {
//                            e.printStackTrace();
//                            // 处理方法未找到的情况
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                            // 处理访问权限问题
//                        } catch (InvocationTargetException e) {
//                            e.printStackTrace();
//                            // 处理方法内部抛出的异常
//                        }
//                    }
//                                            setSpeedMethod = ijkMediaPlayerInstance.getClass().getDeclaredMethod("release");
//                                            setSpeedMethod.invoke(ijkMediaPlayerInstance);
                    // 创建 MediaExtractor
//                                            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
//                                            boolean isMusicPlaying = audioManager.isMusicActive();
                    // 假设我们从某个方法的参数中获取音频源URI

                    // 检查是否有相同的音频正在播放
//                                            if (audioSource.equals(currentPlayingUri)) {
//                                                // 如果相同，则不播放
//                                                return;
//                                            }

//                    init(context);
                    // 检查播放器是否正在播放
                    if (player != null && player.isPlaying()) {
                        // 如果正在播放，则不播放新的媒体
                        return;
                    }
                    AudioManager audioManager = (AudioManager) content.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                    AudioManager.OnAudioFocusChangeListener focusChangeListener = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO) {
                        focusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
                            @Override
                            public void onAudioFocusChange(int focusChange) {
                                // 这里可以根据焦点变化来做出响应，例如暂停或恢复播放
                            }
                        };
                    }

// 请求音频焦点
                    int result = 0;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO) {
                        result = audioManager.requestAudioFocus(focusChangeListener,
                                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                    }

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // 现在已经获得焦点，可以开始播放音频
                        // 如果其他应用正在播放音频，它们应该会暂停或降低音量
                        // 如果不同，设置新的音频源并播放
                        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(audioSource));
                        player.setMediaItem(mediaItem);
                        player.setPlaybackParameters(new PlaybackParameters(4.0f)); // 设置播放速度为2倍
                        player.prepare();
                        player.setPlayWhenReady(true);

                        // 更新当前播放音频源的状态
//                        currentPlayingUri = audioSource;
//                                            //Log.d("2332", "播放加速");
//                                            if (!test) {
//                                                test = true;
//
//                                                SimpleExoPlayer player = new SimpleExoPlayer.Builder(context).build();
//                                                MediaItem mediaItem = MediaItem.fromUri(Uri.parse(audioSource));
//                                                player.setMediaItem(mediaItem);
//                                                player.setPlaybackParameters(new PlaybackParameters(xp.this.currentSpeed )); // 设置播放速度为2倍
//                                                player.prepare();
//                                                player.play();
                    }
                } catch (Exception e) {
                }
                //Log.d(TAG, "File created: " + path);
                break;
            case FileObserver.DELETE:
                //Log.d(TAG, "File deleted: " + path);
                break;
        }
    }

    public void startWatching() {
        super.startWatching();
        //Log.d(TAG, "Start watching directory: " + DIRECTORY_PATH);
    }

    public void stopWatching() {
        super.stopWatching();
        //Log.d(TAG, "Stop watching directory: " + DIRECTORY_PATH);
    }
}