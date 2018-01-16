package tests;

import logging.Logging;
import org.junit.runners.model.RunnerScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.MINUTES;

public class ThreadPoolScheduler implements RunnerScheduler, Logging{

    private static final int TIMEOUT_MINUTES = 10;

    private final ExecutorService executorService;

    ThreadPoolScheduler() {
        this.executorService = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void schedule(Runnable runnable) {
        executorService.submit(runnable);
    }

    @Override
    public void finished() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(TIMEOUT_MINUTES, MINUTES);
        } catch (InterruptedException exc) {
            Thread.currentThread().interrupt();
        }
        getLogger().info(format("Executor state: %s", executorService.toString()));
    }

    static class TestThreadPool implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "TestPool-Thread-" + poolNumber.getAndIncrement());
        }
    }
}
