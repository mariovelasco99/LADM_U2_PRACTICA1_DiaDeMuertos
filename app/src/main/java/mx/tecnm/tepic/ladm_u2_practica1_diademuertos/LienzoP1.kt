package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class LienzoP1 (p:MainActivity) : View(p) {
    val principal = p
    val catrina = BitmapFactory.decodeResource(principal.resources, R.drawable.catrina)
    val lapida = BitmapFactory.decodeResource(principal.resources, R.drawable.lapida)
    val calaverita = BitmapFactory.decodeResource(principal.resources, R.drawable.calaverita)
    val panM = BitmapFactory.decodeResource(principal.resources, R.drawable.pandemuerto)
    var posxCatrina = 1900f
    var lunaIncremento = 0
    var nubesIncremento = 0
    val hiloFlores = MovimientoFlores(this)

    var movimientoCatrina = object : CountDownTimer(2000, 80){
        override fun onTick(p0: Long) {
            posxCatrina -=5
            lunaIncremento += 1
            nubesIncremento += 1
            if(posxCatrina <- 500) posxCatrina = 1900f

            if(lunaIncremento == 1600) lunaIncremento = -200

            if(nubesIncremento == 1600) nubesIncremento = -200
            invalidate() //PARA FORZAR AL onDraw A VOLVERSE A LLAMAR, Y REPINTAR LA CATRINA EN SU RECORRIDO
        }

        override fun onFinish() {
            start()
        }
    }

    //USAMOS EL INIT COMO CONTRUCTOR
    init {
        movimientoCatrina.start()
        hiloFlores.start()
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()     //MI PANTALLA ES DE 1600x720
        //FONDO
        c.drawColor(Color.BLACK)

        //COLINA1
        p.style = Paint.Style.FILL
        p.color = Color.GRAY
        c.drawCircle(350f, 900f, 600f, p)
        p.style = Paint.Style.STROKE
        p.strokeWidth = 5f
        p.color = Color.DKGRAY
        c.drawCircle(350f, 900f, 600f, p)

        //COLINA2
        p.style = Paint.Style.FILL
        p.color = Color.GRAY
        c.drawCircle(1200f, 900f, 600f, p)
        p.style = Paint.Style.STROKE
        p.strokeWidth = 5f
        p.color = Color.DKGRAY
        c.drawCircle(1200f, 900f, 600f, p)

        //ARBOL IZQUIERDA
        p.style = Paint.Style.FILL
        p.color = Color.rgb(180, 114, 20)
        c.drawRect(320f, 250f, 350f, 350f, p)
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawCircle(335f, 210f, 55f, p)
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawCircle(335f, 255f, 55f, p)

        //ARBOL DERECHA
        p.style = Paint.Style.FILL
        p.color = Color.rgb(180, 114, 20)
        c.drawRect(1300f, 250f, 1330f, 350f, p)
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawCircle(1315f, 205f, 55f, p)
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawCircle(1315f, 245f, 55f, p)

        //ARBOL EN MEDIO
        p.style = Paint.Style.FILL
        p.color = Color.rgb(180, 114, 20)
        c.drawRect(770f, 430f, 830f, 530f, p)
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawCircle(800f, 300f, 70f, p)
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawCircle(800f, 380f, 70f, p)

        //LUNA
        p.style = Paint.Style.FILL
        p.color = Color.WHITE
        c.drawCircle(190f+lunaIncremento,80f, 60f, p)
        p.style = Paint.Style.FILL
        p.color = Color.BLACK
        c.drawCircle(210f+lunaIncremento, 60f, 40f, p)

        //NUBE1
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(40f+nubesIncremento, 135f, 35f, p)
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(75f+nubesIncremento, 132f, 35f, p)
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(110f+nubesIncremento, 135f, 35f, p)

        //NUBE2
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(270f+nubesIncremento, 135f, 35f, p)
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(305f+nubesIncremento, 132f, 35f, p)
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(330f+nubesIncremento, 135f, 35f, p)

        //CATRINA INICIO
        c.drawBitmap(catrina, posxCatrina, 100f,p)

        //LAPIDAS COLINA1
        c.drawBitmap(lapida, 110f, 300f, p)
        c.drawBitmap(lapida, 240f, 360f, p)
        c.drawBitmap(lapida, 385f, 400f, p)
        c.drawBitmap(lapida, 440f, 270f, p)
        c.drawBitmap(lapida, 595f, 340f, p)

        //CALAVERITAS LAPIDAS COLINA1
        c.drawBitmap(calaverita,60f,470f, p)
        c.drawBitmap(calaverita,80f, 400f, p)
        c.drawBitmap(calaverita,170f,400f, p)

        c.drawBitmap(calaverita,205f,460f, p)
        c.drawBitmap(calaverita,330f,450f, p)

        c.drawBitmap(calaverita,365f,320f, p)

        c.drawBitmap(calaverita,505f,470f, p)
        c.drawBitmap(calaverita,570f,430f, p)
        c.drawBitmap(calaverita,655f,430f, p)

        //PAN DE MUERTO COLINA1
        c.drawBitmap(panM, 20F, 410f, p)
        c.drawBitmap(panM, 125F, 450f, p)
        c.drawBitmap(panM,220f,315f, p)
        c.drawBitmap(panM,335f,380f, p)
        c.drawBitmap(panM,510f,380f, p)

        //LAPIDAS COLINA2
        c.drawBitmap(lapida, 850f, 400f, p)
        c.drawBitmap(lapida, 970f, 290f, p)
        c.drawBitmap(lapida, 1130f, 230f, p)
        c.drawBitmap(lapida, 1200f, 360f, p)
        c.drawBitmap(lapida, 1400f, 380f, p)

        //CALAVERITAS LAPIDAS COLINA2
        c.drawBitmap(calaverita,910f, 350f, p)
        c.drawBitmap(calaverita,1050f, 420f, p)
        c.drawBitmap(calaverita,1090f, 350f, p)
        c.drawBitmap(calaverita,1220f, 300f, p)
        c.drawBitmap(calaverita, 1320f, 370f, p)
        c.drawBitmap(calaverita,1490f, 435f, p)

        //PAN DE MUERTO COLINA2
        c.drawBitmap(panM,980f, 420f, p)
        c.drawBitmap(panM,1070f, 300f, p)
        c.drawBitmap(panM,1130f, 410f, p)
        c.drawBitmap(panM, 1335f, 435f, p)

        //TEXTO PARA TRATAR QUE NO NOS TRUENEN
        p.textSize = 50f
        p.style = Paint.Style.FILL
        p.color = Color.MAGENTA
        c.drawText("#NoMeRepruebesBenigno", 950f, 530f, p)

        //FLORES DE CEMPASUCHIL
        (0..499).forEach{
            hiloFlores.flores[it].pintarPetalo(c)
        }//forEach

    }
}//classLienzoP1

class MovimientoFlores(p:LienzoP1) : Thread(){
    var  puntero = p
    val flores = ArrayList<Petalos>()

    init {
        (1..500).forEach{
            val petalosF = Petalos(puntero)
            flores.add(petalosF)
        }
    }//init

    override fun run() {
        super.run()
        while (true){
            (0..499).forEach{
                flores[it].moverPetalos()
            }
            puntero.principal.runOnUiThread {
                puntero.invalidate()
            }
            sleep(80)
        }
    }
}//class MovimientoFlores