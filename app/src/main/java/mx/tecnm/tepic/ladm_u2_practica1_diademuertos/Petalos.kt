package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Petalos (p:LienzoP1) {
    var x = 0f
    var y = 0f
    var tam = 0f
    val principal = p
    val florC = BitmapFactory.decodeResource(principal.resources, R.drawable.flor)

    init {
        x = (Math.random()*1700).toFloat()
        y = (Math.random()*1700*-1).toFloat()
        tam = ((Math.random()*5)+5).toFloat()
    }

    fun moverPetalos(){
        y +=tam
        if (y>1000) y = (Math.random()*1700*-1).toFloat()
    }

    fun pintarPetalo(c: Canvas){
        val p = Paint()
        c.drawBitmap(florC, x, y, p)
    }
}//Petalos