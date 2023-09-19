package exception

open class GameException(override val message: String) : RuntimeException(message)

class FileNotFoundException(override val message: String) : GameException(message)

class InvalidArgumentException(override val message: String) : GameException(message)

class InvalidDeckException(override val message: String) : GameException(message)
