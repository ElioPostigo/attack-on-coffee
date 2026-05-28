package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.attackoncoffee.Main;
import com.politecnicomalaga.attackoncoffee.model.Barista;
import com.politecnicomalaga.attackoncoffee.model.Cafe;
import com.politecnicomalaga.attackoncoffee.model.Cliente;
import com.politecnicomalaga.attackoncoffee.model.FilaClientes;
import com.politecnicomalaga.attackoncoffee.model.GrupoClientes;
import com.politecnicomalaga.attackoncoffee.model.Queja;

import java.util.List;

public class GameScreen extends ScreenAdapter {

    private final Main game;
    private final Stage stage;
    private SpriteBatch batch;

    private Barista barista;
    private final GrupoClientes grupoClientes;
    private Texture baristaImage;
    private Texture cafeImage;

    public GameScreen(Main game) {
        baristaImage = new Texture("cliente.png");
        cafeImage = new Texture("cafe.png");
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.barista = new Barista(baristaImage,300,10);
        this.grupoClientes = new GrupoClientes(4, 6, new Texture("cliente.png"), 180f, 400f, 50f, 50f, 10f, 10f);
    }

    @Override
    public void show(){
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0f, 1);

        barista.disparar();
        barista.updatePosition(delta);

        int numCliente = 0;
        for(FilaClientes fila: grupoClientes.getFilas()){
            for(Cliente cliente: fila.getClientes()){
                if(cliente.isActivo()){
                    numCliente++;
                }
            }
        }
        if (numCliente == 0) {
            game.setScreen(new GameOverScreen(game));
        }

        for(Cafe cafe: barista.getCafes()){
            for(FilaClientes fila: grupoClientes.getFilas()){
                for(Cliente cliente: fila.getClientes()){
                    if(cafe.getHitbox().overlaps(cliente.getHitbox()) && cafe.isActivo() && cliente.isActivo()){
                        cliente.setActivo(false);
                        cafe.setActivo(false);
                    }
                }
            }
        }

        grupoClientes.moverVertical(delta);
        batch.begin();
        barista.draw(batch);
        for(FilaClientes fila: grupoClientes.getFilas()){
            for(Cliente cliente: fila.getClientes()){
                if(cliente.isActivo())batch.draw(cliente.getSprite().getTexture(),cliente.getSprite().getX(),cliente.getSprite().getY());
            }
        }
        batch.end();
    }

    @Override
    public void dispose(){
        baristaImage.dispose();
    }
}
