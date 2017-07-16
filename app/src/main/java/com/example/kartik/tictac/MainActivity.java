    package com.example.kartik.tictac;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.LinearLayoutCompat;
    import android.view.View;
    import android.widget.GridLayout;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        int active=0;
       int[] gameStatus={2,2,2,2,2,2,2,2,2};
        //2-unplayed
        int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


                public void dropIn(View view){

                    ImageView counter=(ImageView) view;
                    int tapCount=Integer.parseInt(counter.getTag().toString());

                    if(gameStatus[tapCount]==2) {
                       counter.setTranslationY(-1000f);
                        gameStatus[tapCount]=active;
                        if (active == 0) {
                            counter.setImageResource(R.drawable.countero);
                            active = 1;
                        } else {
                            counter.setImageResource(R.drawable.counterx);
                            active = 0;

                        }
                        counter.animate().translationYBy(1000f).setDuration(300);

                        for(int[] winningPos: winningPositions){
                            if(gameStatus[winningPos[0]]==gameStatus[winningPos[1]] &&
                                    gameStatus[winningPos[1]]==gameStatus[winningPos[2]] &&
                                    gameStatus[winningPos[0]]!=2)
                            {

                                String winner="crosses";
                                if(gameStatus[winningPos[0]]==0) {
                                    winner="0";
                                }
                                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                                    winnerMessage.setText(winner + " has won");

                                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                                    layout.setVisibility(View.VISIBLE);


                            }

                        }

                    }
                }

                public void playAgain(View view){
                   for(int i=0;i<9;i++){
                       System.out.println(gameStatus[i]);
                   }

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.INVISIBLE);
                     active=0;
                    for(int i=0;i<gameStatus.length;i++){

                    gameStatus[i]=2;
                    }
                    //System.out.println(gameStatus[1]);
                    GridLayout gridLayout =(GridLayout)findViewById(R.id.gridLayout);
                    for(int i=0;i<gridLayout.getChildCount();i++)
                    {
                        ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
                    }
                }



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
