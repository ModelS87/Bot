package pro.sky.telegramBot.service;


import org.springframework.stereotype.Service;
import pro.sky.telegramBot.entity.NotificationTask;
import pro.sky.telegramBot.repository.NotificationTaskRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class NotificationTaskService {

    private final NotificationTaskRepository notificationTaskRepository;

    public NotificationTaskService(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }

    @Transactional
    public void save(long chatId, String text, LocalDateTime dateTime) {
        notificationTaskRepository.save(
                new NotificationTask(
                        text,
                        chatId,
                        dateTime.truncatedTo(ChronoUnit.MINUTES)
                )
        );
    }

}
