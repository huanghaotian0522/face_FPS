@Composable
fun BattleScreen(viewModel: BattleViewModel) {
    val scores by viewModel.scores.collectAsState()
    val players by viewModel.players.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        // 队伍分数显示
        Row(modifier = Modifier.align(Alignment.TopCenter)) {
            Text("红队: ${scores.red}", color = Color.Red)
            Spacer(Modifier.width(16.dp))
            Text("蓝队: ${scores.blue}", color = Color.Blue)
        }

        // 玩家血条和位置
        Canvas(modifier = Modifier.fillMaxSize()) {
            players.forEach { player ->
                drawPlayerStatus(player, this)
            }
        }
    }
}

private fun drawPlayerStatus(player: PlayerData, canvas: DrawScope) {
    // 实现玩家位置和血条绘制逻辑
}