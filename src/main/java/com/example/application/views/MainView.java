package com.example.application.views;

import com.example.application.data.dto.MessageDto;
import com.example.application.services.*;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static java.util.Objects.nonNull;

@PageTitle("Classificator")
@Route(value = "my-view")
@RouteAlias(value = "")
@Uses(Icon.class)
public class MainView extends Composite<VerticalLayout> {
    private static final String CATEGORY = "Ваше обращение отнесено к категории: ";
    private static final String PRIORITY = "Установлен приоритет: ";
    private static final String EMPLOYEE = "Назначено сотруднику: ";

    private final Classification classificationService;
    private final Prioritization prioritizationService;
    private final MessageService messageService;

    private MessageList messageList = new MessageList();

    private MessageInput messageInput = new MessageInput();

    public MainView(Classification classificationService,
                    Prioritization prioritizationService,
                    MessageService messageService) {
        this.classificationService = classificationService;
        this.prioritizationService = prioritizationService;
        this.messageService = messageService;
//        HorizontalLayout layoutRow = new HorizontalLayout();
//        AvatarItem avatarItem = new AvatarItem();
//        VerticalLayout layoutColumn2 = new VerticalLayout();
//        MessageList messageList = new MessageList();
//        MessageInput messageInput = new MessageInput();
//        getContent().setWidth("100%");
//        getContent().getStyle().set("flex-grow", "1");
//        layoutRow.addClassName(Gap.MEDIUM);
//        layoutRow.setWidth("100%");
//        layoutRow.setHeight("min-content");
//        layoutRow.setAlignSelf(FlexComponent.Alignment.START, avatarItem);
//        avatarItem.getStyle().set("flex-grow", "1");
//        avatarItem.setHeight("100%");
//        setAvatarItemSampleData(avatarItem);
//        layoutColumn2.setWidth("1500px");
//        layoutColumn2.setHeight("1500px");
//        layoutColumn2.setAlignSelf(FlexComponent.Alignment.END, messageList);
//        messageList.setWidth("100%");
//        messageList.getStyle().set("flex-grow", "1");
//        setMessageListSampleData(messageList);
//        getContent().setAlignSelf(FlexComponent.Alignment.START, messageInput);
//        messageInput.setWidth("100%");
//        getContent().add(layoutRow);
//        layoutRow.add(avatarItem);
//        getContent().add(layoutColumn2);
//        layoutColumn2.add(messageList);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        messageInput.setWidth("100%");
        messageInput.getStyle().set("flex-grow", "1");
        messageList.setWidth("100%");
        messageList.getStyle().set("flex-grow", "1");
//        messageList.getStyle().set("placeholder", "Введите сообщение");


        messageInput.addSubmitListener(this::clickMessageInput);
        getContent().add(messageList);
        getContent().add(messageInput);
    }

    private void clickMessageInput(MessageInput.SubmitEvent e) {
        String messageText = e.getValue();
        if (messageText == null || messageText.isBlank()) {
            return;
        }
        MessageDto message = messageService.retrieveParamsAndSave(messageText);

        String classification = nonNull(message.getCategory()) ? message.getCategory().getTitle() : "";
        String priority = nonNull(message.getPriority()) ? message.getPriority().getTitle() : "";
        String employee = nonNull(message.getEmployee()) ? message.getEmployee().getName() : "";

        MessageListItem mItemClassification = new MessageListItem(classification, LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), CATEGORY);
        MessageListItem mItemPriority = new MessageListItem(priority, LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), PRIORITY);
        MessageListItem mItemEmployee = new MessageListItem(employee, LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), EMPLOYEE);


        messageList.setItems(mItemClassification, mItemPriority, mItemEmployee);
    }


//    private void setAvatarItemSampleData(AvatarItem avatarItem) {
//        avatarItem.setHeading("Aria Bailey");
//        avatarItem.setDescription("Endocrinologist");
//        avatarItem.setAvatar(new Avatar("Aria Bailey"));
//    }
//
//    private void setMessageListSampleData(MessageList messageList) {
//        MessageListItem message1 = new MessageListItem("Nature does not hurry, yet everything gets accomplished.",
//                LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), "Matt Mambo");
//        message1.setUserColorIndex(1);
//        MessageListItem message2 = new MessageListItem(
//                "Using your talent, hobby or profession in a way that makes you contribute with something good to this world is truly the way to go.",
//                LocalDateTime.now().minusMinutes(55).toInstant(ZoneOffset.UTC), "Linsey Listy");
//        message2.setUserColorIndex(2);
//        messageList.setItems(message1, message2);
//    }
}
