package basics

interface Int1
interface Int2
sealed class BaseClass

class ChildClass : BaseClass(),  Int1, Int2

class MovingSprite: Moveable {
    override fun move(direction: Direction, byPixels: Int) {
        /*body*/
    }
}

object Aa2 : BaseClass()

