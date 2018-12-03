1+3

def abs(x: Double) = if (x < 0) -x else x


def sqrt(x: Double) = {

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(guess * guess - x) / x < 0.001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2


  sqrtIter(1.0, x)
}

sqrt(5)
sqrt(1.0e50)
sqrt(0.1e-20)

def factorialtail(x: Int) = {

  def helper(y: Int, acc: Int): Int =
    if (y == 0) acc
    else helper(y-1, y * acc)

  helper(x, 1)
}

factorialtail(16)