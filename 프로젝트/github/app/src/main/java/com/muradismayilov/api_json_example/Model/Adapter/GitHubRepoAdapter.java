package com.muradismayilov.api_json_example.Model.Adapter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.muradismayilov.api_json_example.Model.Pojo.GitHubRepo;
import com.muradismayilov.api_json_example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 6/1/16.
 */
public class GitHubRepoAdapter extends BaseAdapter {

    public static List<GitHubRepo> gitHubRepos = new ArrayList<>();

    @Override public int getCount() {
        return gitHubRepos.size();
    }

    @Override public GitHubRepo getItem(int position) {
        if (position < 0 || position >= gitHubRepos.size()) {
            return null;
        } else {
            return gitHubRepos.get(position);
        }
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        final View view = (convertView != null ? convertView : createView(parent));
        final GitHubRepoViewHolder viewHolder = (GitHubRepoViewHolder) view.getTag();
        viewHolder.setGitHubRepo(getItem(position));
        return view;
    }

    public void setGitHubRepos(@Nullable List<GitHubRepo> repos) {
        if (repos == null) {
            return;
        }
        gitHubRepos.clear();
        gitHubRepos.addAll(repos);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_repo, parent, false);
        final GitHubRepoViewHolder viewHolder = new GitHubRepoViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    public void add(GitHubRepo gitHubRepo) {
        gitHubRepos.add(gitHubRepo);
        notifyDataSetChanged();
    }

    public static GitHubRepo getSelectedGithubRepo(int position) {
        return gitHubRepos.get(position);
    }

    private static class GitHubRepoViewHolder {

        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textCreated;
        private TextView textStars;

        public GitHubRepoViewHolder(View view) {
            textRepoName = (TextView) view.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) view.findViewById(R.id.text_language);
            textCreated = (TextView) view.findViewById(R.id.text_created_at);
            textStars = (TextView) view.findViewById(R.id.text_stars);
        }

        public void setGitHubRepo(GitHubRepo gitHubRepo) {
            textRepoName.setText(gitHubRepo.name);
            textRepoDescription.setText(gitHubRepo.description);
            textLanguage.setText("Language: " + gitHubRepo.language);
            StringBuilder str = new StringBuilder(gitHubRepo.created_at);
            int startIdx = str.indexOf("T");
            int endIdx = str.indexOf("Z");
            str.replace(startIdx, ++endIdx, "");
            String string = str.toString().replace('-', '/');
            textCreated.setText("Created: " + string);
            textStars.setText("Stars: " + gitHubRepo.stargazersCount);
        }
    }
}
