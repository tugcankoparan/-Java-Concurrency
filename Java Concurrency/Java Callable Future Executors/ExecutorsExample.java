package com.tugcankoparan.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

 
class TaskWithResult implements Callable<String> {
	
	int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		return "Result of task id: " + id;
	}
	
}

public class ExecutorsExample {
	
	public static void main(String [] args) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		ExecutorService exec = Executors.newFixedThreadPool(availableProcessors);
		List<Future<String>> results = new ArrayList<Future<String>>();
		for(int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs: results) {
			try {
				System.out.println(fs.get());  
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}
}
