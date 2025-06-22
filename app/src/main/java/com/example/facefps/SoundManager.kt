class SoundManager(context: Context) {
    private val soundPool = SoundPool.Builder().setMaxStreams(2).build()
    private var deathSoundId = 0

    init {
        soundPool.setOnLoadCompleteListener { _, _, status ->
            if (status != 0) Log.e("Sound", "加载失败")
        }
        deathSoundId = soundPool.load(context, R.raw.death_sound, 1)
    }

    fun playDeathSound() {
        soundPool.play(deathSoundId, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    fun release() {
        soundPool.release()
    }
}