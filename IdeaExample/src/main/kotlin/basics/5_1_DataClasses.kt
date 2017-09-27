package basics

data class GitUser(
        val username: String = "default user",
        val pass: String = "default pass",
        var colorMode: Int = 0)

// default 'username' and 'colorMode'
val user1 = GitUser(pass = "qwerty")
// new 'username', same 'pass' and 'colorMode' like 'user1'
val user2 = user1.copy(username = "git_novice")
