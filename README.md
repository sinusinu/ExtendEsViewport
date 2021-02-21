# ExtendEsViewport

ExtendEsViewport is my personal attempt to make [libGDX](https://libgdx.com/)'s [ExtendViewport](https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/utils/viewport/ExtendViewport.html) a little bit more easy to use.

It provides 7 extra ```getEs*``` functions that tells:

```java
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
```

Could be useful for quick prototyping, or fixing some old hard-coded placements to fit in any aspect ratio.

## License

ExtendEsViewport is distributed under the terms of the Do What The Fuck You Want To Public License, Version 2.