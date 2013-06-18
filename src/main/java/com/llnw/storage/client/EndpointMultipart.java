package com.llnw.storage.client;

import com.delvenetworks.statemachine.io.sidechannel.Chunk;
import com.delvenetworks.statemachine.library.TransitionContext;

import org.joda.time.Duration;

import javax.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public interface EndpointMultipart extends Endpoint {
    public String startMultipartUpload(String path, String name) throws IOException;
    public void resumeMultipartUpload(String mpid) throws IOException;
    public void uploadPart(File file, @Nullable Iterator<Chunk> chunks,
            @Nullable Duration heartbeatInterval, @Nullable TransitionContext context) throws IOException;
    public void abortMultipartUpload() throws IOException;
    public void completeMultipartUpload() throws IOException;
}
