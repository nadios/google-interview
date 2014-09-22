package com.nadia.crackcode.vira;


import java.util.List;
import java.util.Map;

/**
 * how to implement a system that collects client data;
 */
public class Task6_OOD_collect_data {


    private class Data {
        String smth1;
        String smth2;
        Integer smth3;
    }

    private interface IService {
        Response storeData(Request request);
    }

    private class Request {
        Map<String, String> fields;
    }

    private class Response {
        String msg;
        Integer status;

        private Response(String msg, Integer status) {
            this.msg = msg;
            this.status = status;
        }
    }

    private class ClientServiceException extends RuntimeException {
    }

    private class ClientService implements IService {

        DataService dataService;

        private Data extractDataFrom(Request request) {
            Data data = new Data();
            data.smth1 = request.fields.get(0);
            data.smth2 = request.fields.get(1);
            data.smth3 = Integer.parseInt(request.fields.get(2));
            return data;
        }

        private void validateData(Data data) throws ClientServiceException {
            if (data.smth1 == null) throw new ClientServiceException();
        }

        @Override
        public Response storeData(Request request) {
            //extract values from request to data object
            Data data = extractDataFrom(request);
            try {
                validateData(data);
            } catch (ClientServiceException exc) {
                return new Response(exc.getMessage(), 400);
            }
            dataService.save(data);
            return new Response("", 200);
        }
    }

    private class DataException extends RuntimeException {
    }

    private class DataService {
        DataDao dataDao;

        public void save(Data data) {
            dataDao.save(data);
        }

        public void delete(Data data) {
           dataDao.delete(data);
        }

        public Data find(String smth1) {
            return dataDao.find(smth1);
        }

        public List<Data> getAll() {
            return dataDao.getAll();
        }
    }

    private class DataDao {
        public void save(Data data) {

        }

        public void delete(Data data) {

        }

        public Data find(String smth1) {
            return null;
        }

        public List<Data> getAll() {
            return null;
        }
    }

}
