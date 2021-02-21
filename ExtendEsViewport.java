/*
 * Copyright © 2021 sinu <cpu344@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * ExtendViewport for dummies.<br/>
 * Stores some extra variables that could be frequently used.
 */
public class ExtendEsViewport extends ExtendViewport {
    public static final int ES_STRETCH_EXACT_RATIO = 0;
    public static final int ES_STRETCH_HORIZONTAL = 1;
    public static final int ES_STRETCH_VERTICAL = 2;

    private float esLeftOffset;
    private float esBottomOffset;
    private float esVisibleWidth;
    private float esVisibleHeight;
    private float esRightOffset;
    private float esTopOffset;
    private int esStretch;

    public ExtendEsViewport(float minWorldWidth, float minWorldHeight) { super(minWorldWidth, minWorldHeight); }
    public ExtendEsViewport(float minWorldWidth, float minWorldHeight, Camera camera) { super(minWorldWidth, minWorldHeight, camera); }
    public ExtendEsViewport(float minWorldWidth, float minWorldHeight, float maxWorldWidth, float maxWorldHeight) { super(minWorldWidth, minWorldHeight, maxWorldWidth, maxWorldHeight); }
    public ExtendEsViewport(float minWorldWidth, float minWorldHeight, float maxWorldWidth, float maxWorldHeight, Camera camera) { super(minWorldWidth, minWorldHeight, maxWorldWidth, maxWorldHeight, camera); }

    @Override
    public void update(int screenWidth, int screenHeight, boolean centerCamera) {
        super.update(screenWidth, screenHeight, centerCamera);

        esLeftOffset = (getMinWorldWidth() - getWorldWidth()) / 2f;
        esBottomOffset = (getMinWorldHeight() - getWorldHeight()) / 2f;
        esVisibleWidth = getWorldWidth();
        esVisibleHeight = getWorldHeight();
        esRightOffset = esVisibleWidth + esLeftOffset;
        esTopOffset = esVisibleHeight + esBottomOffset;
        float relativeRatio = (screenWidth / (float)screenHeight) - (esVisibleWidth / esVisibleHeight);
        if (-0.01f < relativeRatio && relativeRatio < 0.01f) esStretch = ES_STRETCH_EXACT_RATIO;
        else if (relativeRatio > 0.01f) esStretch = ES_STRETCH_HORIZONTAL;
        else if (relativeRatio < -0.01f) esStretch = ES_STRETCH_VERTICAL;
    }

    /** Lowest X (Leftmost) coordinate that is shown. */
    public float getEsLeftOffset() { return esLeftOffset; }
    /** Lowest Y (Bottommost) coordinate that is shown. */
    public float getEsBottomOffset() { return esBottomOffset; }
    /** Width of actually shown region. */
    public float getEsVisibleWidth() { return esVisibleWidth; }
    /** Height of actually shown region. */
    public float getEsVisibleHeight() { return esVisibleHeight; }
    /** Highest X (Rightmost) coordinate that is shown. */
    public float getEsRightOffset() { return esRightOffset; }
    /** Highest Y (Topmost) coordinate that is shown. */
    public float getEsTopOffset() { return esTopOffset; }
    /** Is screen stretched horizontally or vertically? */
    public int getEsStretch() { return esStretch; }
}