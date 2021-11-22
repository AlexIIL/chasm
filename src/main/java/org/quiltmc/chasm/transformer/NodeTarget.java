package org.quiltmc.chasm.transformer;

import org.quiltmc.chasm.tree.Node;

public class NodeTarget implements Target {
    private final NodePath path;

    public NodeTarget(NodePath path) {
        this.path = path;
    }

    public NodePath getPath() {
        return path;
    }

    @Override
    public boolean contains(Target other) {
        if (other instanceof NodeTarget) {
            return path.contains(((NodeTarget) other).path);
        } else if (other instanceof SliceTarget) {
            return path.contains(((SliceTarget) other).getPath());
        } else {
            throw new RuntimeException("Unexpected Target Type");
        }
    }

    @Override
    public boolean overlaps(Target other) {
        return false;
    }

    @Override
    public Node resolve(Node root) {
        return path.resolve(root);
    }
}
