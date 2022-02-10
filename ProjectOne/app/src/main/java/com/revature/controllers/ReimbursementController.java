package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReimbursementController {

    private ReimbursementService rs;
    private ObjectMapper mapper = new ObjectMapper();

    public Handler create = (context) -> {
        Reimbursement r = mapper.readValue(context.body(), Reimbursement.class);

        rs.createReimbursement(r.getId(), r.getAmount(), r.getSubmitted(), r.getResolved(), r.getDescription(),
                r.getAuthor(), r.getResolver(), r.getStatusId(), r.getTypeId());
        context.result(mapper.writeValueAsString(r));
    };

    public Handler update = (context) -> {
        //fix!
        Reimbursement r = mapper.readValue(context.body(), Reimbursement.class);

        context.result(mapper.writeValueAsString(r));
    };

    public Handler getAll = (context) -> {
        context.result(mapper.writeValueAsString(rs.getAll()));
    };

    public Handler getAllPending = (context) -> {
        context.result(mapper.writeValueAsString(rs.getAllPending()));
    };

    public Handler getAllResolved = (context) ->{
        context.result(mapper.writeValueAsString(rs.getAllResolved()));
    };

    public Handler getByAuthor = (context) -> {
        Integer id = Integer.parseInt(context.pathParam("id"));

        context.result(mapper.writeValueAsString(rs.getByAuthor(id)));
    };

    public Handler getByAuthorAndPending = (context) -> {
        Integer id = Integer.parseInt(context.pathParam("id"));

        context.result(mapper.writeValueAsString(rs.getByAuthorAndPending(id)));
    };

    public Handler getByAuthorAndResolved = (context) -> {
        Integer id = Integer.parseInt(context.pathParam("id"));

        context.result(mapper.writeValueAsString(rs.getByAuthorAndResolved(id)));
    };




}
