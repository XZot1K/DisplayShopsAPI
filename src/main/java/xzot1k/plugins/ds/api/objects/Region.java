/*
 * Copyright (c) 2022 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.objects;

public interface Region {

    LocationClone getPointOne();

    void setPointOne(LocationClone pointOne);

    LocationClone getPointTwo();

    void setPointTwo(LocationClone pointTwo);

}