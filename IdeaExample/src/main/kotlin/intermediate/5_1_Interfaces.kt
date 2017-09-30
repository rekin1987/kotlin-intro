package intermediate


private interface InternalInt1
private interface InternalInt2

private interface Int3 : InternalInt1, InternalInt2


enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

class Sprite {
    fun stepForward(){ /*body*/ }
}

interface Movable {
    val sprite:Sprite

    fun move(direction: Direction, byPixels: Int){
        sprite.stepForward()
    }

    fun jump(high: Int) {
        move(Direction.UP, high)
    }
}


class SpriteUser : Movable {
    override val sprite: Sprite = Sprite()
}

