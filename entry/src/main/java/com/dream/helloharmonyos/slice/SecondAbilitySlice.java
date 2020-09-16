package com.dream.helloharmonyos.slice;

import com.dream.helloharmonyos.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.DependentLayout.LayoutConfig;
import ohos.agp.components.Text;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

import static com.dream.helloharmonyos.ResourceTable.*;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_PARENT;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;

public class SecondAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        // 声明布局
        DependentLayout secondLayout = new DependentLayout(this);

        // 设置布局大小
        secondLayout.setWidth(MATCH_PARENT);
        secondLayout.setHeight(MATCH_PARENT);
        ShapeElement element = new ShapeElement();
        element.setRgbColor(new RgbColor(0, 0, 225));
        secondLayout.setBackground(element);

        // 创建一个文本
        Text text = new Text(this);
        text.setId(Id_text);
        text.setText("Welcome to HarmonyOS");
        text.setWidth(MATCH_CONTENT);
        text.setHeight(MATCH_CONTENT);
        text.setTextSize(39);
        text.setTextColor(Color.WHITE);

        Button button = new Button(this);
        button.setId(Id_button);
        button.setText("HomePage");
        button.setWidth(MATCH_CONTENT);
        button.setHeight(MATCH_CONTENT);
        button.setTextSize(30);
        button.setTextColor(Color.RED);
        button.setPadding(80, 8, 80, 20);
        ShapeElement background = new ShapeElement();
        background.setRgbColor(new RgbColor(238, 238, 209));
        background.setShape(6);
        button.setBackground(background);
        button.setTextAlignment(TextAlignment.VERTICAL_CENTER);

        // 设置文本的布局
        DependentLayout.LayoutConfig textConfig = new DependentLayout.LayoutConfig(MATCH_CONTENT,MATCH_CONTENT);
        textConfig.addRule(LayoutConfig.CENTER_IN_PARENT);
        text.setLayoutConfig(textConfig);

        // 设置button的布局
        DependentLayout.LayoutConfig buttonConfig = new DependentLayout.LayoutConfig(MATCH_CONTENT,MATCH_CONTENT);
        buttonConfig.addRule(LayoutConfig.CENTER_IN_PARENT);
        buttonConfig.addRule(LayoutConfig.ALIGN_PARENT_BOTTOM);

//        buttonConfig.addRule(Graphic_button_element);
        button.setLayoutConfig(buttonConfig);

        secondLayout.addComponent(text);
        secondLayout.addComponent(button);

        super.setUIContent(secondLayout);

        if (button != null) {
            // 为按钮设置点击回调
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent mainIntent = new Intent();

                    // 指定待启动FA的bundleName和abilityName
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.dream.helloharmonyos")
                            .withAbilityName("com.dream.helloharmonyos.MainAbility")
                            .build();
                    mainIntent.setOperation(operation);

                    // 通过AbilitySlice的startAbility接口实现启动另一个页面
                    startAbility(mainIntent);
                }
            });
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}