package edu.jhu.fcriscu1.rxjava;

import lombok.extern.log4j.Log4j;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by fcriscuolo on 4/1/16.
 */
@Log4j
public class DirectoryStreamTest {
    public DirectoryStreamTest() {}

    public void processJsonFilesInPath(Path path){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.json")) {

            Observable<Path> jsonObservable = Observable.from(stream);
            jsonObservable.subscribe(new Subscriber<Path>() {
                @Override
                public void onCompleted() {
                    log.info("Json File Count "
                            +TaskCounter.INSTANCE.getCounterValue());
                }

                @Override
                public void onError(Throwable throwable) {
                    log.error(throwable.getMessage());
                }

                @Override
                // write out file content using dedicated thread - should be a mix of content to demonstrate concurrency
                public void onNext(final Path path) {
                    TaskCounter.INSTANCE.incrementCounter();
                    Scheduler.Worker outputWorker = Schedulers.newThread().createWorker();
                    final Subscription schedule = outputWorker.schedule(new Action0() {
                        @Override
                        public void call() {
                            log.info("Thread: " +Thread.currentThread().getName() +"   JSON file: " +path.toString());
                            try {
                                Files.lines(path).forEach( System.out::println);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            TaskCounter.INSTANCE.decrementCounter();
                            log.info("Finished " +path.toString());
                        }
                    });

                }
            });

            while(TaskCounter.INSTANCE.getCounterValue()>0){
                Thread.sleep(500L);
            }
            log.info("Completed");

        } catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Path tmpPath = Paths.get("/tmp");
        DirectoryStreamTest test = new DirectoryStreamTest();
        test.processJsonFilesInPath(tmpPath);


    }
}
