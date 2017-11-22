package com.floatvideo.popup.extractor.playlist;

import com.floatvideo.popup.extractor.UrlIdHandler;
import com.floatvideo.popup.extractor.exceptions.ExtractionException;
import com.floatvideo.popup.extractor.exceptions.ParsingException;
import com.floatvideo.popup.extractor.stream_info.StreamInfoItemCollector;

import java.io.IOException;

public abstract class PlayListExtractor {

    private int serviceId;
    private String url;
    private UrlIdHandler urlIdHandler;
    private StreamInfoItemCollector previewInfoCollector;
    private int page = -1;

    public PlayListExtractor(UrlIdHandler urlIdHandler, String url, int page, int serviceId)
            throws ExtractionException, IOException {
        this.url = url;
        this.page = page;
        this.serviceId = serviceId;
        this.urlIdHandler = urlIdHandler;
        previewInfoCollector = new StreamInfoItemCollector(urlIdHandler, serviceId);
    }

    public String getUrl() { return url; }
    public UrlIdHandler getUrlIdHandler() { return urlIdHandler; }
    public StreamInfoItemCollector getStreamPreviewInfoCollector() {
        return previewInfoCollector;
    }

    public abstract String getName() throws ParsingException;
    public abstract String getAvatarUrl() throws ParsingException;
    public abstract String getBannerUrl() throws ParsingException;
    public abstract StreamInfoItemCollector getStreams() throws ParsingException;
    public abstract boolean hasNextPage() throws ParsingException;
    public int getServiceId() {
        return serviceId;
    }
}
