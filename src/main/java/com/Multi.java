package com;

import java.io.IOException;
import java.nio.file.Path;

class Multi extends Thread {
	Path dir;
	private static WatcherService watcherService;

	public Multi(Path dir) throws IOException {
		this.dir = dir;
		watcherService = new WatcherService(dir);

	}

	public void run() {

		watcherService.processEvents();
		System.out.println("thread is running...");
	}
}
