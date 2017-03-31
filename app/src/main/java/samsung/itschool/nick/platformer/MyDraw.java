package samsung.itschool.nick.platformer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static samsung.itschool.nick.platformer.FirstSplashDraw.height;
import static samsung.itschool.nick.platformer.FirstSplashDraw.width;
import static samsung.itschool.nick.platformer.Hero.pos;
import static samsung.itschool.nick.platformer.MainActivity.fire;
import static samsung.itschool.nick.platformer.SuperAdapter.levelId;


/**
 * Created by User on 29.12.2016.
 */

public class MyDraw extends View  {

    public static int mDirection;
    public static int turnDirection;
    public static int side = 0;
    private static final int Up = 1;
    private static final int Down = 2;
    private static final int Right = 3;
    private static final int Left = 4;




    void start(Context context)
    {
        int id = levelId+1;
        thrower = BitmapFactory.decodeResource(context.getResources(), R.drawable.thrower);
        throwerl = BitmapFactory.decodeResource(context.getResources(), R.drawable.throwerl);
        herostpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.herost);
        heropic = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero);
        heropicl = BitmapFactory.decodeResource(context.getResources(), R.drawable.herol);
        ladderpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.ladder);
        blockpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
        mobpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.mob);
        doorpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.door);
        bulletpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);


        try {
            /*

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания

            // считаем сначала первую строку*/

            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("a.txt"));
            BufferedReader reader = new BufferedReader(istream);







            String line_ = reader.readLine();
            line_ = reader.readLine();
            line_ = reader.readLine();
            String[] levs_ = line_.split(";");
            String[] words_ = levs_[id].split(" ");
            String Name = words_[1];

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            hero = new Hero(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005, 1, context);
            //hero.pos.set(200.1f,400f);


            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Ladd = 2;
            N_Ladd = Integer.parseInt(words_[1]);
            //int N_Ladd = Integer.parseInt(words_[1]);
            ladder = new Ladder[N_Ladd];

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderY2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Blo = 1;
            N_Blo = Integer.parseInt(words_[1]);
            //int N_Blo = Integer.parseInt(words_[1]);
            block = new Block[N_Blo];

            Log.i(TAG, N_Blo + " ++++++++++++++++++++++++++++++");

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockY2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String Background = words_[1];

            int resourceId = context.getResources().getIdentifier(Background, "drawable", context.getPackageName());

            background = BitmapFactory.decodeResource(context.getResources(), resourceId);


            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            door = new Door(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005, doorpic, context);


            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Mob = 1;
            N_Mob = Integer.parseInt(words_[1]);
            //int N_Blo = Integer.parseInt(words_[1]);
            mob = new Mob[N_Mob];

            //Log.i(TAG, N_Blo + " ++++++++++++++++++++++++++++++");

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobY2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobSPX = words_;

            reader.close();

            for(int i = 0; i < ladder.length; i++){
                ladder[i] = new Ladder(Float.parseFloat(ladderX1[2*i+1])*width/1920,Float.parseFloat(ladderY1[2*i+1])*height/1005,Float.parseFloat(ladderX2[2*i+1])*width/1920,Float.parseFloat(ladderY2[2*i+1])*height/1005,
                        context, ladderpic);
            }

            for(int i = 0; i < block.length; i++){
                //Log.i(TAG,Float.parseFloat(blockX1[i])+ Float.parseFloat(blockY1[i])+ Float.parseFloat(blockX2[i])+Float.parseFloat(blockY2[i])+ " ");
                block[i] = new Block(Float.parseFloat(blockX1[2*i+1])*width/1920,Float.parseFloat(blockY1[2*i+1])*height/1005,Float.parseFloat(blockX2[2*i+1])*width/1920,Float.parseFloat(blockY2[2*i+1])*height/1005,
                        context, blockpic);
            }

            for(int i = 0; i < mob.length; i++){
                mob[i] = new Mob(Float.parseFloat(mobX1[2*i+1])*width/1920,Float.parseFloat(mobY1[2*i+1])*height/1005,Float.parseFloat(mobX2[2*i+1])*width/1920,Float.parseFloat(mobY2[2*i+1])*height/1005,
                        Float.parseFloat(mobSPX[2*i+1])*width/1920, mobpic);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i(TAG,"///////////////////////////////////////////////////");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,"--------------------------------------------------");
        }

        /*
        for(int i = 0; i < ladder.length; i++){
            ladder[i] = new Ladder(480,270,580,760,
                    context, R.drawable.ladder);
        }
        hero = new Hero(600,750-200, 1, context, R.drawable.hero);

        block[0] = new Block(0,845,480,845+10,context, R.drawable.block);
        block[1] = new Block(480,760,960,760+10,context, R.drawable.block);
        block[2] = new Block(960,675,1920,675+10,context, R.drawable.block);
        block[3] = new Block(960,405,1920,405+10,context, R.drawable.block);
        block[4] = new Block(480,270,960,270+10,context, R.drawable.block);
        */

    }
    Hero hero;
    Door door;
    Block[] block;
    Ladder[] ladder;
    Mob[] mob;
    static ArrayList<Bullet> bullet = new ArrayList<>();

    Bitmap background;
    Bitmap heropic;
    Bitmap heropicl;
    Bitmap herostpic;
    Bitmap ladderpic;
    Bitmap blockpic;
    Bitmap mobpic;
    Bitmap doorpic;
    Bitmap thrower;
    Bitmap throwerl;
    static Bitmap bulletpic;
    Paint p = new Paint();

    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        start(context);
        this.context = context;
    }


    void Physic(float w, float h){

        onGround = false;
        onLadder = false;



        for (int i = 0; i < block.length; i++) {

            if (block[i].y1 <= hero.pos.y +90 && block[i].y1 >= hero.pos.y
                    && block[i].x1 <= hero.pos.x
                    && block[i].x2 >= hero.pos.x){
                onGround = true;
                hero.toGo.setY(hero.pos.y);
                //hero.pos.setY(hero.pos.y);
            }
        }
        for (int i = 0; i < ladder.length; i++){
            if (ladder[i].y1 <= hero.pos.y & ladder[i].y2 >= hero.pos.y & ladder[i].x1 <= hero.pos.x & ladder[i].x2 >= hero.pos.x ){
                onLadder = true;
                //hero.toGo.setY(hero.pos.y);
            }
        }
        for (int i = 0; i < mob.length; i++) {

            if (mob[i].y1 - 90 <= hero.pos.y && mob[i].y2 + 90 >= hero.pos.y
                    && mob[i].x1 - 90  <= hero.pos.x
                    && mob[i].x2 + 90 >= hero.pos.x){
                bullet.clear();

                start(getContext());
            }
        }
        if (pos.y > h + 200 || pos.y < 0-200 || pos.x > w + 300 || pos.x < 0 - 300   ){
            bullet.clear();

            start(getContext());
        }
        if (bullet.size() > 0) {
            for (int i = 0; i < mob.length; i++) {
                for (int j = 0; j < bullet.size(); j++) {
                    if (mob[i].y1 <= bullet.get(j).y & mob[i].y2 >= bullet.get(j).y & mob[i].x1 <= bullet.get(j).x + bulletpic.getWidth() & mob[i].x2 >= bullet.get(j).x) {
                        mob[i].isalife = false;
                        bullet.get(j).isalife = false;
                        //hero.toGo.setY(hero.pos.y);
                    }
                }
            }
        }




    }
    boolean onLadder;
    boolean onGround;
/* Поменять всеееее при вводе карты!!!!!!!!!!!!!!!!!*/
    Context context;
    RectF rectF;
    @Override
    public void onDraw(Canvas canvas) {
        //Log.i(TAG,canvas.getHeight() + " " + canvas.getWidth() );


        Physic(canvas.getWidth(), canvas.getHeight());
        rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawBitmap(background, null, rectF , p);
        //canvas.drawColor(Color.GREEN);
        for (int i = 0; i < block.length; i++){
            block[i].draw(canvas, blockpic);
        }
        for (int i = 0; i < ladder.length; i++){
            ladder[i].draw(canvas, ladderpic);
        }

        for (int i = 0; i < mob.length; i++){
            if(mob[i].isalife){
            mob[i].draw(canvas, mobpic);
            mob[i].move(canvas);}
            else {mob[i].y1 -= 10000;
                mob[i].y2 -= 10000;}
        }
        if (bullet.size() > 0) {
            for (int i = 0; i < bullet.size(); i++) {
                if (bullet.get(i).isalife) {
                    bullet.get(i).move(canvas);
                    bullet.get(i).draw(canvas);
                } else {
                    bullet.remove(i);
                }
            }
        }


        switch (mDirection) {
            case Up: {
                side = 0;
                if(onLadder && onGround){
                    //hero.toGo.setY(pos.y-50*height/1080);
                    hero.pos.setY(pos.y-50*height/1080);
                }
                else if(onLadder && !onGround){
                    hero.toGo.setY(pos.y-50*height/1080);
                }else if (onGround && !onLadder){
                    hero.pos.setY(pos.y-175*height/1080);

                    //hero.toGo.setY(pos.y-2050);


                }


                break;
            }

            case Down: {
                side = 0;



                if(onLadder && onGround){
                    hero.pos.setY(pos.y+15*height/1080);}
                else if(onLadder && !onGround){
                    hero.toGo.setY(pos.y+40*height/1080);
                }else if (onGround && !onLadder){
                    hero.pos.setY(pos.y+5*height/1080);

                    //hero.toGo.setY(pos.y-2050);


                }


                break;
            }




        }


        switch (turnDirection) {

            case Right: {
                side = 3;
                if (onGround == false && onLadder == false ) hero.toGo.setX(pos.x+100*width/1920);
                else hero.toGo.setX(pos.x+45*width/1920);

                break;
            }
            case Left: {
                side = 4;
                if (onGround == false && onLadder == false ) hero.toGo.setX(pos.x-100*width/1920);
                else hero.toGo.setX(pos.x-45*width/1920);

                break;
            }

        }
        if (fire == 0) {
            if (side == 4) {
                hero.draw(canvas, heropicl);
            } else if (side == 3) {
                hero.draw(canvas, heropic);
            } else hero.draw(canvas, herostpic);
        }else if(fire == -1){
            fire = 0;
            hero.draw(canvas, throwerl);
        }else{
            fire = 0;
            hero.draw(canvas, thrower);
        }
        Physic(canvas.getWidth(), canvas.getHeight());


        if (onGround == false && onLadder == false ){
            //Toast.makeText(this.getContext(), "Toast", Toast.LENGTH_SHORT).show();
            hero.toGo.setY( (hero.pos.y + 100*height/1080));

        }




        hero.move(canvas);
        door.draw(canvas);

        if (door.x <= pos.x && door.x + doorpic.getWidth() >= pos.x && door.y <= pos.y && door.y + doorpic.getHeight() >= pos.y){



            bullet.clear();
            levelId += 1;
            start(getContext());

        }



        this.invalidate();
    }



}