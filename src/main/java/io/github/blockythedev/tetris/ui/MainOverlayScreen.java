/*
 * School Project - Tetris Game
 * Copyright (C) 2023 BlockyTheDev <https://github.com/BlockyTheDev>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.blockythedev.tetris.ui;

import io.github.blockythedev.tetris.constants.GameConstants;
import io.github.blockythedev.tetris.constants.StringConstants;
import io.github.blockythedev.tetris.logic.GameManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

/**
 * <b>This class contains the overlay for the main screen.</b>
 */
public class MainOverlayScreen extends JPanel {
    private final GameManager gameManager;
    private final JLabel statsText;

    /**
     * <b>The constructor for the {@link MainOverlayScreen} UI.</b>
     *
     * @param gameManager An {@link GameManager} instance
     */
    public MainOverlayScreen(@NotNull final GameManager gameManager) {
        this.gameManager = gameManager;
        statsText = new JLabel(MessageFormat.format(StringConstants.LABEL_TEXT_SCORE, 0));
    }

    /**
     * <b>Initialise the UI of {@link MainOverlayScreen}.</b>
     */
    public void initUI() {
        setLayout(new BorderLayout());
        setOpaque(false);
        statsText.setHorizontalAlignment(SwingConstants.LEFT);
        statsText.setVerticalAlignment(SwingConstants.TOP);
        final Font oldFont = statsText.getFont();
        statsText.setFont(oldFont.deriveFont(oldFont.getSize() * GameConstants.FONT_FACTOR));
        add(statsText, BorderLayout.NORTH);
    }

    /**
     * <b>Refreshes the stats text.</b>
     */
    public void updateStatsText() {
        statsText.setText(MessageFormat.format(StringConstants.LABEL_TEXT_SCORE, gameManager.getStats().getRemovedLines()));
    }
}
