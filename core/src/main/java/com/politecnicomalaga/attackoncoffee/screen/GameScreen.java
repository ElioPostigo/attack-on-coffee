package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.politecnicomalaga.attackoncoffee.Main;
import com.politecnicomalaga.attackoncoffee.manager.SettingsManager;
import com.politecnicomalaga.attackoncoffee.model.Barista;
import com.politecnicomalaga.attackoncoffee.model.Cafe;
import com.politecnicomalaga.attackoncoffee.model.Cliente;
import com.politecnicomalaga.attackoncoffee.model.FilaClientes;
import com.politecnicomalaga.attackoncoffee.model.GrupoClientes;
import com.politecnicomalaga.attackoncoffee.model.Queja;

public class GameScreen extends ScreenAdapter {

    private final Main game;
    private final Stage stage;
    private SpriteBatch batch;

    private Barista barista;
    private final GrupoClientes grupoClientes;
    private Texture baristaImage;
    private Texture cafeImage;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Sound explosionSound;
    private Music backgroundMusic;

    public GameScreen(Main game) {
        baristaImage = new Texture("cliente.png");
        cafeImage = new Texture("cafe.png");
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.barista = new Barista(baristaImage,300,10);
        this.grupoClientes = new GrupoClientes(4, 6, new Texture("cliente.png"), 100f, 420f, 80f, 50f, 30f, 30f);
    }

    @Override
    public void show(){
        camera = new OrthographicCamera(SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
        batch = new SpriteBatch();
        viewport = new StretchViewport(SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT, camera);
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosionSound.mp3"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/hormigueroSong.mp3"));

        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(1.2f);
        backgroundMusic.play();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0f, 1);

        barista.updatePosition(delta);

        int numCliente = 0;
        for(FilaClientes fila: grupoClientes.getFilas()){
            for(Cliente cliente: fila.getClientes()){
                if(cliente.getHitbox().overlaps(barista.getHitbox())) {
                    backgroundMusic.stop();
                    game.setScreen(new GameOverScreen(game));
                }
                if(cliente.isActivo()){
                    numCliente++;
                }
            }
        }
        if (numCliente == 0) {
            backgroundMusic.stop();
            game.setScreen(new WinScreen(game));
        }

        for (FilaClientes fila : grupoClientes.getFilas()) {
            for (Cliente cliente : fila.getClientes()) {
                if (cliente.isActivo()) {
                    // Disparar quejas aleatoriamente (ejemplo: cada 2 segundos)
                    if (Math.random() < 0.001) { // Ajusta la probabilidad según necesites
                        cliente.lanzarQueja(cafeImage);
                    }

                    // Mover y dibujar quejas del cliente
                    for (Queja queja : cliente.getQuejas()) {
                        if (queja.isActivo()) {
                            queja.mover();
                            if (queja.getHitbox().overlaps(barista.getHitbox())) {
                                queja.setActivo(false);
                                backgroundMusic.stop();
                                game.setScreen(new GameOverScreen(game));
                            }
                        }
                    }
                }
            }
        }

        for(Cafe cafe: barista.getCafes()){
            for(FilaClientes fila: grupoClientes.getFilas()){
                for(Cliente cliente: fila.getClientes()){
                    if(cafe.getHitbox().overlaps(cliente.getHitbox()) && cafe.isActivo() && cliente.isActivo()){
                        cliente.setActivo(false);
                        cafe.setActivo(false);
                        explosionSound.play(0.4f);
                    }
                }
            }
        }

        grupoClientes.mover(delta);
        batch.begin();
        barista.draw(batch);
        for(FilaClientes fila: grupoClientes.getFilas()){
            for(Cliente cliente: fila.getClientes()){
                if(cliente.isActivo()){
                    batch.draw(cliente.getSprite().getTexture(),cliente.getSprite().getX(),cliente.getSprite().getY());
                    for (Queja queja : cliente.getQuejas()) {
                        if (queja.isActivo()) {
                            batch.draw(
                                queja.getSprite().getTexture(),
                                queja.getSprite().getX(),
                                queja.getSprite().getY(),
                                queja.getSprite().getWidth(),
                                queja.getSprite().getHeight()
                            );
                        }
                    }
                }
            }
        }
        batch.end();
    }

    @Override
    public void dispose(){
        baristaImage.dispose();
        batch.dispose();
        cafeImage.dispose();
        stage.dispose();
        if (explosionSound != null) explosionSound.dispose();

        // Liberar música
        if (backgroundMusic != null) backgroundMusic.dispose();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
