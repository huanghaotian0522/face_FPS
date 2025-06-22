class FirebaseBattleManager(private val roomId: String) {
    private val db = Firebase.database.reference

    fun startDeathDetection() {
        db.child("rooms/$roomId/players").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val teams = mutableMapOf("red" to true, "blue" to true)

                snapshot.children.forEach { player ->
                    player.child("health").getValue(Int::class.java)?.let {
                        if (it > 0) teams[player.child("team").getValue(String::class.java)] = false
                    }
                }

                when {
                    teams["red"] == true -> updateScore("blue")
                    teams["blue"] == true -> updateScore("red")
                }
            }

            private fun updateScore(winningTeam: String) {
                db.child("rooms/$roomId/scores/$winningTeam").runTransaction {
                    val current = (it.getValue(Int::class.java) ?: 0) + 1
                    it.value = current
                    Transaction.success(it)
                }
            }

            override fun onCancelled(error: DatabaseError) { 
                // 错误处理
            }
        })
    }
}