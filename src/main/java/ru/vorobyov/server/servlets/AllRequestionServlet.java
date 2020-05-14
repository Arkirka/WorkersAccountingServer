package ru.vorobyov.server.servlets;

import ru.vorobyov.database.entity.JobInfo;
import ru.vorobyov.database.entity.Worker;
import ru.vorobyov.database.service.WorkerService;
import ru.vorobyov.server.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllRequestionServlet extends HttpServlet {

    //lists for entity
    List<Worker> workerList = null;
    List<JobInfo> jobInfoList = null;
    //lists for table
    List<Integer> workerId = null;
    List<String> preview = null;
    List<String> name = null;
    List<String> lastName = null;

    public AllRequestionServlet() {

        //init workerList
        try {
            WorkerService workerService = new WorkerService();
            workerList = workerService.getAll();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();

        //doTable();

        pageVariables.put("name", workerList);

        response.getWriter().println(PageGenerator.instance().getPage("page.ftl", pageVariables));

        response.setContentType("encoding;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void doTable() {
        for(Worker worker: workerList) {

        }
    }
}
