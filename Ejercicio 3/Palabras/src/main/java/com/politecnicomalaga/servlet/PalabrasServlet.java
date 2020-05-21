package com.politecnicomalaga.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.politecnicomalaga.Concatenacion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(
        name = "palabras",
        urlPatterns = {"/palabras"}
)

public class PalabrasServlet extends HttpServlet {
    Logger logger = Logger.getLogger(PalabrasServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String concatenado;
        String resultado;
        Concatenacion concatenacion = new Concatenacion();
        Gson gson = new Gson();
        String json = req.getReader().lines().collect(Collectors.joining());
        logger.info(json);
        try {
            Type collectionType = new TypeToken<Collection<String>>(){}.getType();
            List<String> palabras = gson.fromJson(json,collectionType);
            concatenado = concatenacion.concatenar(palabras);
            resultado = "{\"status\":\"ok\",\"palabraA\":\""+palabras.get(0)+"\",\"palabraB\":\""+palabras.get(1)+"\",\"palabraC\":\""+palabras.get(2)+"\",\"concatenado\":\""+concatenado+"\"}";
        } catch (Exception e) {
            resultado = "{\"status\":\"ko\"}";
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(resultado);
    }
}
