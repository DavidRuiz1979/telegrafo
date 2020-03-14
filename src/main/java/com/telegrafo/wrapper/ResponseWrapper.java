package com.telegrafo.wrapper;


import com.telegrafo.model.Status;

public class ResponseWrapper<T> {
    private Status status;
    private Error error;
    private T data;

    private ResponseWrapper() {
    }

    private ResponseWrapper(Status status, Error error,T data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <K> ResponseWrapper.Builder<K> builder() {
        return new ResponseWrapper.Builder();
    }

    public String toString() {
        return "ResponseWrapper{status=" + this.status + ", error=" + this.error + ", data=" + this.data + "}";
    }

    public static class Builder<T1> {
        private Status status;
        private Error error;
        private T1 data;

        public Builder() {
        }

        public ResponseWrapper.Builder setStatus(Status s) {
            this.status = s;
            return this;
        }

        public ResponseWrapper.Builder setError(Error e) {
            this.error = e;
            return this;
        }


        public ResponseWrapper.Builder setData(T1 d) {
            this.data = d;
            return this;
        }

        public ResponseWrapper<T1> build() {
            return new ResponseWrapper(this.status, this.error, this.data);
        }
    }
}
