package org.pcs.codingsolutions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
}
