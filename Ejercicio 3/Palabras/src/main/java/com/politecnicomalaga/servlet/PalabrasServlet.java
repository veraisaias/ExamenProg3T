package com.politecnicomalaga.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.politecnicomalaga.Concatenacion;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(
        name = "palabras",
        urlPatterns = {"/palabras"}
)

public class PalabrasServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String concatenado;
        String resultado;
        Concatenacion concatenacion = new Concatenacion();
        Gson gson = new Gson();
        String json = req.getReader().lines().collect(Collectors.joining());
        try {
            Type collectionType = new TypeToken<Collection<String>>(){}.getType();
            List<String> palabras = gson.fromJson(json,collectionType);
            concatenado = concatenacion.concatenar(palabras);
            resultado =
        } catch (Exception e) {
            resultado = "{\"status\":\"ko\"}";
            e.printStackTrace();
        }
    }
}
