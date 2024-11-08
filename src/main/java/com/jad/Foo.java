package com.jad;

import java.util.List;

public class Foo {
    public Foo(final IBar bar) {
    }

    public IBar getBar() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<IBaz> getBazs() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addBaz(final IBaz baz) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public IQux getQux() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ICorge getCorge() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setCorge(final ICorge firstCorge) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
