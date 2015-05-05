package net.unverschaemt.pinFever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Home extends ActionBarActivity {
    public final static String GAME = "net.unverschaemt.PinFever.GAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*TODO: Remove! Only For Testing*/
        User ownUser = new User("982n3o98uch", "Kkoile", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        Game[] games = new Game[10];
        User u1 = new User("98hzo2in3re", "Peter", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u2 = new User("dn98znx98zn", "Robin", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u3 = new User("98znx98u3n0", "Dehlen", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u4 = new User("09u7nx9n82n", "Dustin", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u5 = new User("98724nc97xj", "Hex0r", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u6 = new User("576nx982nsz", "Pottsau", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u7 = new User("323nx9x9732", "Zettel", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u8 = new User("9834nc09x20", "Kaputt", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u9 = new User("c29873nmj02", "Uboot", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);
        User u10 = new User("woieun22zei", "Hase", "Nils Hirsekorn", "Nils_Hirsekorn@online.de", R.mipmap.dummy_avatar);

        games[0] = new Game("987d3c87hd", u1);
        games[1] = new Game("98fnf8720a", u2);
        games[2] = new Game("097vh307cn", u3);
        games[3] = new Game("lc98u3ndc8", u4);
        games[4] = new Game("803nc8cn27", u5);
        games[5] = new Game("987d3c87hd", u6);
        games[6] = new Game("98fnf8720a", u7);
        games[7] = new Game("097vh307cn", u8);
        games[8] = new Game("lc98u3ndc8", u9);
        games[9] = new Game("803nc8cn27", u10);

        for(Game game : games){
            List<Question> questions;
            List<Round> rounds = new ArrayList<Round>();
            questions = new ArrayList<Question>();
            questions.add(new Question("idn983nbd9", "Science", "Was ist...", 2, 1));
            questions.add(new Question("98zho3nr98", "Science", "Wo ist...", 1, 1));
            questions.add(new Question("dh308hd03h", "Science", "Wer ist...", 1, 0));
            rounds.add(new Round(questions));
            questions = new ArrayList<Question>();
            questions.add(new Question("idn983nbd9", "Nature", "Was ist...", 3, 2));
            questions.add(new Question("98zho3nr98", "Nature", "Wo ist...", 2, 1));
            questions.add(new Question("dh308hd03h", "Nature", "Wer ist...", 1, 2));
            rounds.add(new Round(questions));
            questions = new ArrayList<Question>();
            questions.add(new Question("idn983nbd9", "Religion", "Was ist...", 2, 3));
            questions.add(new Question("98zho3nr98", "Religion", "Wo ist...", 1, 0));
            questions.add(new Question("dh308hd03h", "Religion", "Wer ist...", 1, 1));
            rounds.add(new Round(questions));

            game.addRounds(rounds);
        }
        /*****/
        setContentView(R.layout.activity_home);
        fillActiveGames(games);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeAvatar(View view){
        Toast.makeText(this, "TODO: Change Avatar", Toast.LENGTH_SHORT).show();
    }

    public void settings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void friends(View view){
        Intent intent = new Intent(this, FriendsList.class);
        startActivity(intent);
    }

    public void newGame(View view) {
        Intent intent = new Intent(this, NewGame.class);
        startActivity(intent);
    }

    public void fillActiveGames(Game[] games){
        ListView activeGames = (ListView) findViewById(R.id.Home_activeGames);
        activeGames.setAdapter(new GameListAdapter(this, games));
    }
}
