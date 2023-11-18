package com.example.application.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Classificator")
@Route(value = "my-view")
@RouteAlias(value = "")
@Uses(Icon.class)
public class MainView extends Composite<VerticalLayout> {

    public MainView() {
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
//
        MessageInput messageInput = new MessageInput();
        getContent().add(messageInput);
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
