package fr.mygdx.game.splashscreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class Splash implements Screen{
	private SpriteBatch batch;
	private Sprite splash;
	@Override
	public void show() {
		Texture splashTexture = new Texture ("PremierFinal.jpg");
		splash = new Sprite(splashTexture);
		splash.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
	}

	@Override
	public void render(float delta) {
		batch.begin();
		splash.draw(batch);
		batch.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}
