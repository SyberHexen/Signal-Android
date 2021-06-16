package org.thoughtcrime.securesms.wallpaper;

import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import org.thoughtcrime.securesms.conversation.colors.ChatColors;
import org.thoughtcrime.securesms.conversation.colors.ChatColorsMapper;
import org.thoughtcrime.securesms.conversation.colors.ChatColorsPalette;
import org.thoughtcrime.securesms.database.model.databaseprotos.Wallpaper;

import java.util.Arrays;
import java.util.List;

public interface ChatWallpaper extends Parcelable {

  float FIXED_DIM_LEVEL_FOR_DARK_THEME = 0.2f;

  float getDimLevelForDarkTheme();

  default @NonNull ChatColors getAutoChatColors() {
    return ChatColorsMapper.getChatColors(this).withId(ChatColors.Id.Auto.INSTANCE);
  }

  boolean isSameSource(@NonNull ChatWallpaper chatWallpaper);

  void loadInto(@NonNull ImageView imageView);

  @NonNull Wallpaper serialize();

  enum BuiltIns {
    INSTANCE;

    @NonNull List<ChatWallpaper> getAllBuiltIns() {
      return Arrays.asList(
          SingleColorChatWallpaper.BLUSH,
          SingleColorChatWallpaper.COPPER,
          SingleColorChatWallpaper.DUST,
          SingleColorChatWallpaper.CELADON,
          SingleColorChatWallpaper.RAINFOREST,
          SingleColorChatWallpaper.PACIFIC,
          SingleColorChatWallpaper.FROST,
          SingleColorChatWallpaper.NAVY,
          SingleColorChatWallpaper.LILAC,
          SingleColorChatWallpaper.PINK,
          SingleColorChatWallpaper.EGGPLANT,
          SingleColorChatWallpaper.SILVER,
          SingleColorChatWallpaper.BLACK,
          GradientChatWallpaper.SUNSET,
          GradientChatWallpaper.NOIR,
          GradientChatWallpaper.HEATMAP,
          GradientChatWallpaper.AQUA,
          GradientChatWallpaper.IRIDESCENT,
          GradientChatWallpaper.MONSTERA,
          GradientChatWallpaper.BLISS,
          GradientChatWallpaper.SKY,
          GradientChatWallpaper.PEACH);
    }
  }
}
